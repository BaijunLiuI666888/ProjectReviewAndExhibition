using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using SVCSserver.DAL;
using SVCSserver.Models;

namespace SVCSserver.Controllers
{
    public class PostTagsController : Controller
    {
        private SVCSContext db = new SVCSContext();

        // GET: PostTags
        public async Task<ActionResult> Index()
        {
            var postTags = db.PostTags.Include(p => p.Post).Include(p => p.Tag);
            return View(await postTags.ToListAsync());
        }

        // GET: PostTags/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PostTags postTags = await db.PostTags.FindAsync(id);
            if (postTags == null)
            {
                return HttpNotFound();
            }
            return View(postTags);
        }

        // GET: PostTags/Create
        public ActionResult Create()
        {
            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title");
            ViewBag.TagID = new SelectList(db.Tags, "TagID", "content");
            return View();
        }

        // POST: PostTags/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "PostTagsID,TagID,PostID")] PostTags postTags)
        {
            if (ModelState.IsValid)
            {
                db.PostTags.Add(postTags);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title", postTags.PostID);
            ViewBag.TagID = new SelectList(db.Tags, "TagID", "content", postTags.TagID);
            return View(postTags);
        }

        // GET: PostTags/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PostTags postTags = await db.PostTags.FindAsync(id);
            if (postTags == null)
            {
                return HttpNotFound();
            }
            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title", postTags.PostID);
            ViewBag.TagID = new SelectList(db.Tags, "TagID", "content", postTags.TagID);
            return View(postTags);
        }

        // POST: PostTags/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "PostTagsID,TagID,PostID")] PostTags postTags)
        {
            if (ModelState.IsValid)
            {
                db.Entry(postTags).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewBag.PostID = new SelectList(db.Posts, "PostID", "Title", postTags.PostID);
            ViewBag.TagID = new SelectList(db.Tags, "TagID", "content", postTags.TagID);
            return View(postTags);
        }

        // GET: PostTags/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            PostTags postTags = await db.PostTags.FindAsync(id);
            if (postTags == null)
            {
                return HttpNotFound();
            }
            return View(postTags);
        }

        // POST: PostTags/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            PostTags postTags = await db.PostTags.FindAsync(id);
            db.PostTags.Remove(postTags);
            await db.SaveChangesAsync();
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
