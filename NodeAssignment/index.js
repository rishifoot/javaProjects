const express = require("express");
const session = require("express-session");
const flash = require("express-flash");
const sequelize = require("./util/database");
const Student = require("./models/student");
const Teacher = require("./models/teacher");
const Result = require("./models/result");
const bcrypt = require('bcrypt');
const saltRounds = 10;

Teacher.hasMany(Student);

// express application
const app = express();


//registering the view engine
app.set("view engine", "ejs");
app.set("views", "./views");
app.use(express.static(__dirname + "/public"));

app.use(express.json());
app.use(express.urlencoded({ extended: false }));


//session  initialization
app.use(
  session({
    secret: "123456catr",
    resave: false,
    saveUninitialized: true,
    cookie: { maxAge: 60000 },
  })
);


//for store message in the session
app.use(flash());




//creating  Teacher data
const createTeacher = async (req, res) => {
    var name = req.body.name;
  var password = req.body.password;
  var email = req.body.email;
  const salt = await bcrypt.genSalt(saltRounds);
  var encryptedPassword = await bcrypt.hash(password, salt);
  sequelize
    .sync()
    .then((result) => {
      Teacher.create({
        name: name,
        password: encryptedPassword,
        email: email,
      });
      console.log(result);
    })
    .then((teacher) => {
      console.log("First Teacher Created : ", teacher);
    })
    .catch((err) => {
      console.log(err);
    });
}


//Creating Student data
const createStudent = async (req, res) => {
    var name = req.body.name;
    var password = req.body.password;
    const salt = await bcrypt.genSalt(saltRounds);
    var encryptedPassword =  await bcrypt.hash(password, salt);
    var email = req.body.email;
  
    sequelize
      .sync()
      .then((result) => {
        Student.create({
          name: name,
          password: encryptedPassword,
          email: email,
        });
        console.log(result);
      })
      .then((student) => {
        console.log("First Student Created : ", student);
      })
      .catch((err) => {
        console.log(err);
      });
}


//fetching result data from the database
function result() {
  Result.findAll().then((results) => {
    return results;
  });
}


//hash password for store in the database
const hash = async(req, res, password) =>{
    const salt = await bcrypt.genSalt(saltRounds);
    var encryptedPassword = await bcrypt.hash(password, salt);
    return encryptedPassword;
}


//listening for requests
app.listen(3000, () => {
  console.log("Server started at port 3000");
});



//root route
app.get("/", (req, res) => {
  res.render("home");
});




//teacher login route
app.get("/teacher-login", (req, res) => {
  res.render("login");
});



//student login route
app.get("/student-login", (req, res) => {
  res.render("login1");
});



//route to take teacher login credentials
app.get("/teacher-login-form", (req, res) => {
  res.render("teacher-form");
});




//route to take student login credentials
app.get("/student-login-form", (req, res) => {
  res.render("student-form");
});



//route to get request to add new result in the database
app.get("/new-result", (req, res) => {
  res.render("new-result");
});



//route to post request to add new result in the database
app.post("/add-new-result", (req, res) => {
  var name = req.body.name;
  var rollno = req.body.rollno;
  var dob = req.body.dob;
  var score = req.body.score;

  sequelize
    .sync()
    .then((result) => {
      Result.create({
        studentName: name,
        studentRollNo:rollno,
        dateOfBirth:dob,
        score:score
      });
      console.log(result);
    })
    .then((result) => {
      res.redirect("/teacher-dashboard");
    })
    .catch((err) => {
      console.log(err);
    });
    
});


//route to update data in the database
app.get('/update/(:id)',(req,res)=>{
  var id = req.params.id;
  Result.findOne({
    where: {
      studentRollNo: id
    }
  }).then((result)=>{
    res.render('update-result',{result:result});
  });
});




//route to fetch data which we want to update
app.post("/update-existing-result", (req, res) => {
  var name = req.body.name;
  var rollno = req.body.rollno;
  var dob = req.body.dob;
  var score = req.body.score;

  Result.update({studentName:name, studentRollNo:rollno,dateOfBirth: dob, score:score},{
    where: {
      studentRollNo: rollno
      }
    }).then((result) => { 
      res.redirect("/teacher-dashboard");
    })
});




//route to validate student login credentials from database
app.post("/student-dashboard", (req, res) => {

 //Fetching User details
  var password = req.body.password;
  var email = req.body.email;
 
  Student.findOne({ where: {email: email } }).then(
    (student) => {
      if (student) {
        bcrypt.compare(password, student.password, function(err, result) {
            if (result) {
                res.render("student-dashboard");
                }
            else{
                res.render("student-login");
            }
        });
      }else{
        res.render("student-login");
      } 
    }
  );
});




//route to access teacher dashboard
app.post("/teacher-dashboard", (req, res) => {
  Result.findAll().then((results) => {
    res.render("teacher-dashboard", { results: results });
  });
});



//route to access teacher dashboard
app.get("/teacher-dashboard", (req, res) => {
  Result.findAll().then((results) => {
    res.render("teacher-dashboard", { results: results });
  });
});




//route to validate teacher login credentials from database
app.post("/teacher-dashboard", (req, res) => {
  var password = req.body.password;
  var email = req.body.email;
  var encryptedPassword = hash(req, res, password);
  console.log(encryptedPassword);
  Teacher.findOne({ where: {email: email } }).then(
    (teacher) => {
      if (teacher) {
        bcrypt.compare(password, teacher.password, function(err, result) {
            if (result) {
              Result.findAll().then((results) => {
                res.render("teacher-dashboard", { results: results });
              });
              }
            else{
                res.render("teacher-login");
            }
        });
      } 
    }
  );
});




//route to save teacher data into database
app.post("/student-login", (req, res) => {
  createStudent(req, res);
  res.render("login1");
});





//route to save teacher data into database
app.post("/teacher-login", (req, res) => {
  createTeacher(req,res);
  res.render("login");
});




//route to delete result from the database
app.get('/delete/(:id)',(req,res)=>{
  var id = req.params.id;
  Result.destroy({
    where: {
      studentRollNo: id
    }
  }).then(()=>{
    res.redirect('/teacher-dashboard');
  });
});


app.post("/student-result", (req, res) => {
  var name = req.body.name;
  var rollno = req.body.rollno;
  var dob = req.body.dob;
  
  Result.findOne({
    where: {
      studentRollNo: rollno,
      studentName:name
      }}).then((result)=>{
        if(result){
          res.render("show-result",{result:result});
        }else{
          res.render("error");
        }
      });
});