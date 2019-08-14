using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCSserver.Models
{
    public class UserCommentDTO
    {   //user
        public int ID { get; set; }
        public string UserString { get; set; }
        public string Email { get; set; }
        public byte[] PhotoAVTR { get; set; }
        public int ExperiencePoint { get; set; }


        //post
        public int postiD { get; set; }
        public int postCommenCount { get; set; }

        public string Title { get; set; }


        //comment
        public string commentCommentText { get; set; }
        public int commentLikeCount { get; set; }
    }
}
