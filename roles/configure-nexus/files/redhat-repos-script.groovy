// this is the exploded content for redhat-repos.json
// to do development on this script, load up the nexus example repo in your IDE for code completion and then copy here and into redhat-repo.json. https://github.com/sonatype/nexus-book-examples/tree/nexus-3.x/scripting/nexus-script-example 

// not the prettiest code I've written, but it's really the only way to config manage nexus

import org.sonatype.nexus.blobstore.api.BlobStoreManager
import org.sonatype.nexus.repository.maven.LayoutPolicy
import org.sonatype.nexus.repository.maven.VersionPolicy
import org.sonatype.nexus.repository.storage.WritePolicy

if ( !repository.repositoryManager.exists( 'jboss-public' ) ){
    repository.createMavenProxy('jboss-public','https://repository.jboss.org/nexus/content/groups/public/', BlobStoreManager.DEFAULT_BLOBSTORE_NAME, true, VersionPolicy.MIXED, LayoutPolicy.STRICT)
}

if ( !repository.repositoryManager.exists( 'jboss-ea' ) ){
    repository.createMavenProxy('jboss-ea','http://maven.repository.redhat.com/techpreview/all/')
}

if ( !repository.repositoryManager.exists( 'redhat-ga' ) ){
    repository.createMavenProxy('redhat-ga','https://maven.repository.redhat.com/ga/')
}

if ( !repository.repositoryManager.exists( 'redhat-earlyaccess-all' ) ){
    repository.createMavenProxy('redhat-earlyaccess-all','https://maven.repository.redhat.com/earlyaccess/all/', BlobStoreManager.DEFAULT_BLOBSTORE_NAME, true, VersionPolicy.MIXED, LayoutPolicy.STRICT)
}

if ( !repository.repositoryManager.exists( 'redhat-public' ) ){
    repository.createMavenGroup('redhat-public', ['jboss-public','jboss-ea','redhat-earlyaccess-all','redhat-ga'])
}

