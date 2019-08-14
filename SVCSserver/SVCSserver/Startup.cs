using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(SVCSserver.Startup))]
namespace SVCSserver
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
