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
    public class PostCommentsController : Controller
    {
        private SVCSContext db = new SVCSContext();

        // GET: PostComments
        public ActionResult Index()
        {
            var postComments = db.PostComments.Include(p => p.Post).Include(p => p.User);
            return View(postComments.ToList());
        }

        // GET: PostComments/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PostComment postComment = db.PostComments.Find(id);
            if (postComment == null)
            {
                return HttpNotFound();
            }
            return View(postComment);
        }

        // GET: PostComments/Create
        public ActionResult Create()
        {
            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title");
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString");
            return View();
        }

        // POST: PostComments/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "PostCommentID,UserID,PostID,Text,LikeCount")] PostComment postComment)
        {
            if (ModelState.IsValid)
            {
                db.PostComments.Add(postComment);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title", postComment.PostID);
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString", postComment.UserID);
            return View(postComment);
        }

        // GET: PostComments/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PostComment postComment = db.PostComments.Find(id);
            if (postComment == null)
            {
                return HttpNotFound();
            }
            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title", postComment.PostID);
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString", postComment.UserID);
            return View(postComment);
        }

        // POST: PostComments/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "PostCommentID,UserID,PostID,Text,LikeCount")] PostComment postComment)
        {
            if (ModelState.IsValid)
            {
                db.Entry(postComment).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title", postComment.PostID);
            ViewBag.UserID = new SelectList(db.Users, "ID", "UserString", postComment.UserID);
            return View(postComment);
        }

        // GET: PostComments/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PostComment postComment = db.PostComments.Find(id);
            if (postComment == null)
            {
                return HttpNotFound();
            }
            return View(postComment);
        }

        // POST: PostComments/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            PostComment postComment = db.PostComments.Find(id);
            db.PostComments.Remove(postComment);
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
