using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCSserver.Models
{
    public class TagOnPostsDTO
    {
        public int TagID { get; set; }
        public int PostID { get; set; }
        public string content { get; set; }

        public int ID { get; set; }
        public string UserString { get; set; }
        public string Email { get; set; }
        public byte[] PhotoAVTR { get; set; }
        public int ExperiencePoint { get; set; }


        
        public string Title { get; set; }
        public string Text { get; set; }
        public byte[] Photo1 { get; set; }
        public byte[] Photo2 { get; set; }
        public byte[] Photo3 { get; set; }
        public byte[] Photo4 { get; set; }
        public byte[] Photo5 { get; set; }
        public byte[] Photo6 { get; set; }
        public byte[] Photo7 { get; set; }
        public byte[] Photo8 { get; set; }
        public byte[] Photo9 { get; set; }
        public int LikeCount { get; set; }
        public int CommenCount { get; set; }
        public string Location { get; set; }

        public DateTime CreateDate { get; set; }
    }
}