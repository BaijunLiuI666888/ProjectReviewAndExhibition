using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCS.Models
{
    public class PostComment
    {
        public int PostCommentID { get; set;}
        public int UserID { get; set; }
        public int PostID { get; set; }
        public string Text { get; set; }
        public int LikeCount { get; set; }
        public virtual User User { get; set; }
        public virtual Post Post { get; set; }

    }
}