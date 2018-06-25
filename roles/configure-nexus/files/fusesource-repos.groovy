// this is the exploded content for redhat-repos.json
// to do development on this script, load up the nexus example repo in your IDE for code completion and then copy here and into redhat-repo.json. https://github.com/sonatype/nexus-book-examples/tree/nexus-3.x/scripting/nexus-script-example 

// not the prettiest code I've written, but it's really the only way to config manage nexus

if ( !repository.repositoryManager.exists( 'fusesource.m2' ) ){
    repository.createMavenProxy('fusesource.m2','https://repo.fusesource.com/nexus/content/groups/public/')
};

if ( !repository.repositoryManager.exists( 'fusesource.ea' ) ){
    repository.createMavenProxy('fusesource.ea','https://repo.fusesource.com/nexus/content/groups/ea/')
};

if ( !repository.repositoryManager.exists( 'fusesource-public' ) ){
    repository.createMavenGroup('fusesource-public', ['fusesource.m2','fusesource.ea'])
}
