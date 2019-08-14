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
    public class APIPostTagsController : ApiController
    {
        private SVCSContext db = new SVCSContext();
        public APIPostTagsController()
        {
            // Add the following code
            // problem will be solved
            db.Configuration.ProxyCreationEnabled = false;
        }
        // GET: api/PostTags
        public IQueryable<PostTags> GetPostTags()
        {
            return db.PostTags;
        }
        [ResponseType(typeof(TagDTO))]
        // GET: api/PostTags/5
        [ResponseType(typeof(TagDTO))]
        public IQueryable<TagDTO> GetPostTags(int id)
        {
            var tags = from t in db.PostTags
                        where t.PostID == id
                        select new TagDTO()
                        {   TagID=t.TagID,
                            TagContent=t.Tag.content,
                            
    };

            return tags;
        }

        // PUT: api/PostTags/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutPostTags(int id, PostTags postTags)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != postTags.PostTagsID)
            {
                return BadRequest();
            }

            db.Entry(postTags).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PostTagsExists(id))
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

        // POST: api/PostTags
        [ResponseType(typeof(PostTags))]
        public async Task<IHttpActionResult> PostPostTags(PostTags postTags)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.PostTags.Add(postTags);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = postTags.PostTagsID }, postTags);
        }

        // DELETE: api/PostTags/5
        [ResponseType(typeof(PostTags))]
        public async Task<IHttpActionResult> DeletePostTags(int id)
        {
            PostTags postTags = await db.PostTags.FindAsync(id);
            if (postTags == null)
            {
                return NotFound();
            }

            db.PostTags.Remove(postTags);
            await db.SaveChangesAsync();

            return Ok(postTags);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PostTagsExists(int id)
        {
            return db.PostTags.Count(e => e.PostTagsID == id) > 0;
        }
    }
}