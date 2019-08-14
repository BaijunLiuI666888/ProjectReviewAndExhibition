using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Description;
using SVCS.Models;
using SVCSserver.DAL;
using SVCSserver.Models;

namespace SVCSserver.APIController
{
    public class APIPostsController : ApiController
    {
        private SVCSContext db = new SVCSContext();

        public APIPostsController()
        {
            // Add the following code
            // problem will be solved
            db.Configuration.ProxyCreationEnabled = false;
        }
        // GET: api/APIPost
        public IQueryable<ListPostsDTO> GetPosts()
        {
            var posts = from p in db.Posts
                        select new ListPostsDTO()
                        {
                            ID = p.User.ID,
                            UserString = p.User.UserString,
                            Email = p.User.Email,
                            PhotoAVTR = p.User.PhotoAVTR,
                            ExperiencePoint = p.User.ExperiencePoint,
                            PostID = p.PostID,
                            Title = p.Title,
                            Text = p.Text,
                            Photo1 = p.Photo1,
                            Photo2 = p.Photo2,
                            Photo3 = p.Photo3,
                            Photo4 = p.Photo4,
                            Photo5 = p.Photo5,
                            Photo6 = p.Photo6,
                            Photo7 = p.Photo7,
                            Photo8 = p.Photo8,
                            Photo9 = p.Photo9,
                            LikeCount = p.LikeCount,
                            CommenCount = p.CommenCount,
                            Location = p.Location,
                            CreateDate = p.CreateDate,


                        };

            return posts;

        }
        // GET: api/APIPosts/5
        [ResponseType(typeof(ListPostsDTO))]
        
        public  IQueryable<ListPostsDTO> GetPost(int id)
        {
            var posts = from p in db.Posts
                        where p.PostID == id
                        select new ListPostsDTO()
                        {
                            ID = p.User.ID,
                            UserString = p.User.UserString,
                            Email = p.User.Email,
                            PhotoAVTR = p.User.PhotoAVTR,
                            ExperiencePoint = p.User.ExperiencePoint,
                            PostID = p.PostID,
                            Title = p.Title,
                            Text = p.Text,
                            Photo1 = p.Photo1,
                            Photo2 = p.Photo2,
                            Photo3 = p.Photo3,
                            Photo4 = p.Photo4,
                            Photo5 = p.Photo5,
                            Photo6 = p.Photo6,
                            Photo7 = p.Photo7,
                            Photo8 = p.Photo8,
                            Photo9 = p.Photo9,
                            LikeCount = p.LikeCount,
                            CommenCount = p.CommenCount,
                            Location = p.Location,
                            CreateDate = p.CreateDate,
                            


                        };

            return posts;
        }

        // PUT: api/APIPosts/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutPost(int id, Post apipost)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            int like = apipost.LikeCount;

            var post = new Post() { PostID = id, LikeCount = like + 1 };

            db.Posts.Attach(post);
            db.Entry(post).Property(x => x.LikeCount).IsModified = true;
            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PostExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }
        // PUT: api/APIPosts/5
        [ResponseType(typeof(void))]

        [Route("APIPosts/{PostID}/PutLike")]
        public async Task<IHttpActionResult> PutLike(int PostID, Post apipost)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            int like = apipost.LikeCount;

            var post = new Post() { PostID = PostID, LikeCount = like + 1 };

            db.Posts.Attach(post);
            db.Entry(post).Property(x => x.LikeCount).IsModified = true;
            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PostExists(PostID))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/APIPosts
        [ResponseType(typeof(ListPostsDTO))]
        public async Task<IHttpActionResult> PostPost(ListPostsDTO post)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            Post p = new Post();
            var user= from std in db.Users
                      where std.Email == post.Email                    
                      select std;
            p.UserID = user.First().ID;
            p.Title = post.Title;
            p.Text = post.Text;
            p.Photo1 = post.Photo1;
            p.CommenCount = 0;
            p.LikeCount = 0;
            p.Location = post.Location;
            p.CreateDate = DateTime.UtcNow.Date;
            db.Posts.Add(p);
            
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = post.PostID }, post);
        }

        // DELETE: api/APIPosts/5
        [ResponseType(typeof(Post))]
        public async Task<IHttpActionResult> DeletePost(int id)
        {
            Post post = await db.Posts.FindAsync(id);
            if (post == null)
            {
                return NotFound();
            }

            db.Posts.Remove(post);
            await db.SaveChangesAsync();

            return Ok(post);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PostExists(int id)
        {
            return db.Posts.Count(e => e.PostID == id) > 0;
        }
    }
}