using SVCS.Models;
using SVCSserver.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SVCSserver.DAL
{
    public class SVCSInitializer : System.Data.Entity.DropCreateDatabaseIfModelChanges<SVCSContext>
    {
        protected override void Seed(SVCSContext context)
        {
            var users = new List<User>
            {
            new User{UserString="Trump", Email="carson.com",Password="psw",FirstName="Alexander",LastName="gg",Phone="123456",Address="123456",JoinDate=DateTime.Parse("2005-09-01"),DateofBurth=DateTime.Parse("2005-09-01"),ExperiencePoint=56,level=56,Status=Status.AT},
             new User{UserString="Baijun", Email="lbjsfuture@outlook.com",Password="LBJnn19960606",FirstName="baijun",LastName="liu",Phone="0830650893",Address="139 college manor",JoinDate=DateTime.Parse("2019-02-01"),DateofBurth=DateTime.Parse("1997-04-20"),ExperiencePoint=6686,level=6,Status=Status.AT},

            };

            users.ForEach(s => context.Users.Add(s));
            context.SaveChanges();

            var tags = new List<Tag>
            {
            new Tag{content="#Nice Places"},
            new Tag{content="#Travel"},
            new Tag{content="#Food"},
            new Tag{content="#Drink"},
            new Tag{content="#StreetWear"},
            new Tag{content="#Models"},
            new Tag{content="#NiceDay"},
            new Tag{content="#Happy"},
            new Tag{content="#Moody"},
            new Tag{content="#Cool"},
            new Tag{content="#Nice"},
            new Tag{content="#interesting"},
            new Tag{content="#unforgetable"},
            new Tag{content="#Easy"},
            new Tag{content="#Priceless"},

            };

            tags.ForEach(t => context.Tags.Add(t));
            context.SaveChanges();
        }
    }
}

