using SVCSserver.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCS.Models
{
    public enum Location
    {
        Dublin, Cork, NorthIreland, Dundalk,
        America,
        British,
        NetherLand,
        Canada,
        China,
        Japan
       
    }
    public class Post
    {
        public int PostID { get; set; }
        public int UserID { get; set; }
        public string Title { get; set; }
        public string Text { get; set; }
        public byte[] Photo1 { get; set; }
        public byte[] Photo2 { get; set; }
        public byte[] Photo3 { get; set; }
        public byte[] Photo4{ get; set; }
        public byte[] Photo5 { get; set; }
        public byte[] Photo6 { get; set; }
        public byte[] Photo7 { get; set; }
        public byte[] Photo8 { get; set; }
        public byte[] Photo9 { get; set; }
        public int LikeCount { get; set; }
        public int CommenCount { get; set; }
        public string Location { get; set; }
        public DateTime CreateDate { get; set; }
        
        public virtual User User { get; set; }
        public virtual ICollection<PostComment> PostComments { get; set; }
        public virtual ICollection<PostTags> PostTags { get; set; }
    }
}