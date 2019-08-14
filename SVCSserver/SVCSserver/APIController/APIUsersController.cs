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

namespace SVCSserver.APIController
{
    public class APIUsersController : ApiController
    {
        private SVCSContext db = new SVCSContext();
        public APIUsersController()
        {
            // Add the following code
            // problem will be solved
            db.Configuration.ProxyCreationEnabled = false;
        }
        // GET: api/APIUsers
        public IQueryable<User> GetUsers()
        {
            return db.Users;
        }

        // GET: api/APIUsers/5
        [ResponseType(typeof(User))]
        public IHttpActionResult GetUser(string id)
        {


            User user = new User();
            var userfound = from std in db.Users
                            where std.Email == id
                            select std;

                user = userfound.First();
            // the rul http://localhost:50421/api/apiusers?id=iop@iop.com
            if (user == null)
            {
                return NotFound();
            }





            return Ok(user);
        }

        // PUT: api/APIUsers/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutUser(int id, User user)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != user.ID)
            {
                return BadRequest();
            }

            db.Entry(user).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!UserExists(id))
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

        // POST: api/APIUsers
        [ResponseType(typeof(User))]
        public async Task<IHttpActionResult> PostUser(User user)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            user.DateofBurth= DateTime.UtcNow.Date;
            user.JoinDate= DateTime.UtcNow.Date;
            db.Users.Add(user);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = user.ID }, user);
        }

        // DELETE: api/APIUsers/5
        [ResponseType(typeof(User))]
        public async Task<IHttpActionResult> DeleteUser(int id)
        {
            User user = await db.Users.FindAsync(id);
            if (user == null)
            {
                return NotFound();
            }

            db.Users.Remove(user);
            await db.SaveChangesAsync();

            return Ok(user);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool UserExists(int id)
        {
            return db.Users.Count(e => e.ID == id) > 0;
        }
    }
}