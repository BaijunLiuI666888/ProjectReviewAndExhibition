using SVCS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCSserver.Models
{
    public class Tag
    {
        public int TagID { get; set; }
        
        public string content { get; set; }

        public virtual ICollection<PostTags> PostTags { get; set; }

    }
}