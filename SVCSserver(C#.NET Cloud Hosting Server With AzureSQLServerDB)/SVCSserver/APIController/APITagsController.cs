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
using SVCSserver.DAL;
using SVCSserver.Models;

namespace SVCSserver.APIController
{
    public class APITagsController : ApiController
    {
        private SVCSContext db = new SVCSContext();
        public APITagsController()
        {
            // Add the following code
            // problem will be solved
            db.Configuration.ProxyCreationEnabled = false;
        }
        // GET: api/Tags
        public IQueryable<Tag> GetTags()
        {
            return db.Tags;
        }

        // GET: api/Tags/5
        [ResponseType(typeof(TagOnPostsDTO))]

        public IQueryable<TagOnPostsDTO> GetPost(int id)
        {
            var posts = from tg in db.Tags
                        join pt in db.PostTags on tg.TagID equals pt.TagID
                        join p in db.Posts on pt.PostID equals p.PostID
                        where pt.TagID == id
                        select new TagOnPostsDTO()
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
                            TagID=pt.TagID,
                            content=tg.content



                        };

            return posts;
        }

        // PUT: api/Tags/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutTag(int id, Tag tag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != tag.TagID)
            {
                return BadRequest();
            }

            db.Entry(tag).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TagExists(id))
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

        // POST: api/Tags
        [ResponseType(typeof(Tag))]
        public async Task<IHttpActionResult> PostTag(Tag tag)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Tags.Add(tag);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = tag.TagID }, tag);
        }

        // DELETE: api/Tags/5
        [ResponseType(typeof(Tag))]
        public async Task<IHttpActionResult> DeleteTag(int id)
        {
            Tag tag = await db.Tags.FindAsync(id);
            if (tag == null)
            {
                return NotFound();
            }

            db.Tags.Remove(tag);
            await db.SaveChangesAsync();

            return Ok(tag);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TagExists(int id)
        {
            return db.Tags.Count(e => e.TagID == id) > 0;
        }
    }
}