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
    public class APIPostCommentsController : ApiController
    {
        private SVCSContext db = new SVCSContext();
        public APIPostCommentsController()
        {
            // Add the following code
            // problem will be solved
            db.Configuration.ProxyCreationEnabled = false;
        }
        // GET: api/PostComments
        public IQueryable<PostComment> GetPostComments()
        {
            return db.PostComments;
        }

        // GET: api/PostComments/5
        [ResponseType(typeof(UserCommentDTO))]
        public IQueryable<UserCommentDTO> GetPostComment(int id)
        {

            var comments = from p in db.PostComments
                        where p.PostID == id
                        select new UserCommentDTO()
                        {
                            ID = p.User.ID,
                            UserString = p.User.UserString,
                            Email = p.User.Email,
                            PhotoAVTR = p.User.PhotoAVTR,
                            ExperiencePoint = p.User.ExperiencePoint,

                           



                            commentCommentText = p.Text,
                            commentLikeCount = p.LikeCount,
    };

            return comments;
        }

        // PUT: api/PostComments/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutPostComment(int id, PostComment postComment)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != postComment.PostCommentID)
            {
                return BadRequest();
            }

            db.Entry(postComment).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PostCommentExists(id))
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

        // POST: api/PostComments
        [ResponseType(typeof(UserCommentDTO))]
        public async Task<IHttpActionResult> PostPost(UserCommentDTO comment)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            PostComment p = new PostComment();
            var user = from std in db.Users
                       where std.Email == comment.Email
                       select std;
            p.UserID = user.First().ID;
            p.PostID = comment.postiD;
            p.Text = comment.commentCommentText;

            db.PostComments.Add(p);

            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = comment.postiD }, comment);
        }

        // DELETE: api/PostComments/5
        [ResponseType(typeof(PostComment))]
        public async Task<IHttpActionResult> DeletePostComment(int id)
        {
            PostComment postComment = await db.PostComments.FindAsync(id);
            if (postComment == null)
            {
                return NotFound();
            }

            db.PostComments.Remove(postComment);
            await db.SaveChangesAsync();

            return Ok(postComment);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PostCommentExists(int id)
        {
            return db.PostComments.Count(e => e.PostCommentID == id) > 0;
        }
    }
}