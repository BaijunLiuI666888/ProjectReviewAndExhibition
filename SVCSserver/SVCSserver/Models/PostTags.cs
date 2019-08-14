using SVCS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCSserver.Models
{
    public class PostTags
    {
        public int PostTagsID { get; set; }
        public int TagID { get; set; }
        public int PostID { get; set; }

        public virtual Tag Tag { get; set; }
        public virtual Post Post { get; set; }
    }
}