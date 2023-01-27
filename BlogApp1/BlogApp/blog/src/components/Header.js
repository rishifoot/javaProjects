import { Link } from "react-router-dom"

const Header = () => {
    return (
        <header className="Header">
            <nav>
                <ul>
                    <li className="back"><Link to="/">Back </Link></li>
                </ul>
                <div>
                    <Link to="post"><button className="ad">Add blogs</button></Link>
                </div>

            </nav>
        </header>
    )
}

export default Header