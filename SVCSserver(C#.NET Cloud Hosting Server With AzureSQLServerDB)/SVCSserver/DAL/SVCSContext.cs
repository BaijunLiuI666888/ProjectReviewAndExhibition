using SVCS.Models;
using SVCSserver.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Web;

namespace SVCSserver.DAL
{
    public class SVCSContext : DbContext
    {
        public SVCSContext() : base("SVCSContext")
        {
        }
        public DbSet<User> Users { get; set; }
        public DbSet<Post> Posts { get; set; }
        public DbSet<PostComment> PostComments { get; set; }
        public DbSet<Tag> Tags { get; set; }
        public DbSet<PostTags> PostTags { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            modelBuilder.Conventions.Remove<ManyToManyCascadeDeleteConvention>();
            modelBuilder.Conventions.Remove<OneToManyCascadeDeleteConvention>();
            modelBuilder.Entity<Post>()
               .HasOptional(j => j.PostComments)
               .WithMany()
               .WillCascadeOnDelete(true);
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<Post>()
              .HasOptional(j => j.PostTags)
              .WithMany()
              .WillCascadeOnDelete(true);
            base.OnModelCreating(modelBuilder);
        }
    }
}