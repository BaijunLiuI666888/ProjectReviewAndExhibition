using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using SVCS.Models;
using SVCSserver.DAL;

namespace SVCSserver.Controllers
{
    public class PostsController : Controller
    {
        private SVCSContext db = new SVCSContext();

        // GET: Posts
        public ActionResult Index()
        {
            var posts = db.Posts.Include(p => p.User);
            return View(posts.ToList());
        }

        // GET: Posts/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }
            return View(post);
        }

        // GET: Posts/Create
        public ActionResult Create()
        {
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString");
            return View();
        }

        // POST: Posts/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "PostID,UserID,Title,Text,Photo1,Photo2,Photo3,Photo4,Photo5,Photo6,Photo7,Photo8,Photo9,LikeCount,CommenCount,Location,CreateDate")] Post post, HttpPostedFileBase file,HttpPostedFileBase file2, HttpPostedFileBase file3, HttpPostedFileBase file4, HttpPostedFileBase file5, HttpPostedFileBase file6, HttpPostedFileBase file7, HttpPostedFileBase file8, HttpPostedFileBase file9)
        {
            if (ModelState.IsValid)
            {
                if (file != null)
                {
                    post.Photo1 = new byte[file.ContentLength];
                    file.InputStream.Read(post.Photo1, 0, file.ContentLength);
                } if (file2 != null)
                    {
                        post.Photo2 = new byte[file2.ContentLength];
                        file2.InputStream.Read(post.Photo2, 0, file2.ContentLength);
                    } if (file3 != null)
                        {
                            post.Photo3 = new byte[file3.ContentLength];
                            file3.InputStream.Read(post.Photo3, 0, file3.ContentLength);
                        } if (file4 != null)
                            {
                                post.Photo4 = new byte[file4.ContentLength];
                                file4.InputStream.Read(post.Photo4, 0, file4.ContentLength);
                            }
                            if (file5 != null)
                                {
                                    post.Photo5 = new byte[file5.ContentLength];
                                    file5.InputStream.Read(post.Photo5, 0, file5.ContentLength);
                                } if (file6 != null)
                                    {
                                        post.Photo6 = new byte[file6.ContentLength];
                                        file6.InputStream.Read(post.Photo6, 0, file6.ContentLength);
                                    } if (file7 != null)
                                        {
                                            post.Photo7 = new byte[file7.ContentLength];
                                            file7.InputStream.Read(post.Photo7, 0, file7.ContentLength);
                                        } if (file8 != null)
                                            {
                                                post.Photo8 = new byte[file8.ContentLength];
                                                file8.InputStream.Read(post.Photo8, 0, file8.ContentLength);
                                            }
                                            if (file9 != null)
                                                {
                                                    post.Photo9 = new byte[file9.ContentLength];
                                                    file9.InputStream.Read(post.Photo9, 0, file9.ContentLength);

                                                }
 
                db.Posts.Add(post);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString", post.UserID);
            return View(post);
        }

        // GET: Posts/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString", post.UserID);
            return View(post);
        }

        // POST: Posts/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "PostID,UserID,Title,Text,Photo1,Photo2,Photo3,Photo4,Photo5,Photo6,Photo7,Photo8,Photo9,LikeCount,CommenCount,Location,CreateDate")] Post post, HttpPostedFileBase file, HttpPostedFileBase file2, HttpPostedFileBase file3, HttpPostedFileBase file4)
        {
            if (ModelState.IsValid)
            {
                if (file != null)
                {
                    post.Photo1 = new byte[file.ContentLength];
                    file.InputStream.Read(post.Photo1, 0, file.ContentLength);
                }
                if (file2 != null)
                {
                    post.Photo2 = new byte[file2.ContentLength];
                    file2.InputStream.Read(post.Photo2, 0, file2.ContentLength);
                }
                if (file3 != null)
                {
                    post.Photo3 = new byte[file3.ContentLength];
                    file3.InputStream.Read(post.Photo3, 0, file3.ContentLength);
                }
                if (file4 != null)
                {
                    post.Photo4 = new byte[file4.ContentLength];
                    file4.InputStream.Read(post.Photo4, 0, file4.ContentLength);
                }
                db.Entry(post).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString", post.UserID);
            return View(post);
        }

        // GET: Posts/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Post post = db.Posts.Find(id);
            if (post == null)
            {
                return HttpNotFound();
            }
            return View(post);
        }

        // POST: Posts/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Post post = db.Posts.Find(id);
          
            
            db.Posts.Remove(post);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
