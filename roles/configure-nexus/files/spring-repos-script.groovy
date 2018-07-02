// this is the exploded content for redhat-repos.json
// to do development on this script, load up the nexus example repo in your IDE for code completion and then copy here and into redhat-repo.json. https://github.com/sonatype/nexus-book-examples/tree/nexus-3.x/scripting/nexus-script-example 

// not the prettiest code I've written, but it's really the only way to config manage nexus

import org.sonatype.nexus.blobstore.api.BlobStoreManager
import org.sonatype.nexus.repository.maven.LayoutPolicy
import org.sonatype.nexus.repository.maven.VersionPolicy
import org.sonatype.nexus.repository.storage.WritePolicy

if ( !repository.repositoryManager.exists( 'spring-snapshots' ) ){
    repository.createMavenProxy('spring-snapshots','http://repo.spring.io/libs-snapshot-local/', BlobStoreManager.DEFAULT_BLOBSTORE_NAME, true, VersionPolicy.MIXED, LayoutPolicy.STRICT)
}

if ( !repository.repositoryManager.exists( 'spring-milestones' ) ){
    repository.createMavenProxy('spring-milestones','http://repo.spring.io/libs-milestone-local')
}

if ( !repository.repositoryManager.exists( 'spring-releases' ) ){
    repository.createMavenProxy('spring-releases','http://repo.spring.io/release')
}

if ( !repository.repositoryManager.exists( 'spring-public' ) ){
    repository.createMavenGroup('spring-public', ['spring-snapshots','spring-milestones','spring-releases'])
}

