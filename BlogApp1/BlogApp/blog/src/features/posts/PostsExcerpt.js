import ReactionButtons from "./ReactionButtons";
import { Link } from 'react-router-dom';

const PostsExcerpt = ({ post }) => {
    return (
        <article>
            <h2>{post.title}</h2>
            <p className="excerpt">{post.body.substring(0, 75)}...</p>
            <p className="postCredit">
                <Link to={`post/${post.id}`}><button type="button" className="ad" style={{backgroundColor:'yellow'}}>View Post</button></Link>
               
            </p>
            <ReactionButtons post={post} />
        </article>
    )
}
export default PostsExcerpt