using SVCS.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCSserver.Models
{
    public class UserDTO
    {
        public int ID { get; set; }
        public string UserString { get; set; }
        public byte[] PhotoAVTR { get; set; }
        public string Email { get; set; }

        public string Password { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Phone { get; set; }
        public string Address { get; set; }
        public DateTime JoinDate { get; set; }
        public DateTime DateofBurth { get; set; }
        public int ExperiencePoint { get; set; }
        public int level { get; set; }
        public Status Status { get; set; }
    }
}