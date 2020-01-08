# Nexus for OpenShift Enterprise 3

This is instant nexus application for OpenShift Enterprise 3.

Install nexus
```
oc new-project nexus --display-name="Nexus" --description="Nexus"
oc new-app -f https://raw.githubusercontent.com/eformat/openshift-nexus/master/nexus.yaml
```

OR use the operator
```
oc new-project nexus --display-name="Nexus" --description="Nexus"
oc apply -f https://raw.githubusercontent.com/eformat/openshift-nexus/master/nexus-operator.yaml
oc apply -f https://raw.githubusercontent.com/eformat/openshift-nexus/master/nexus-cr.yaml
```

Login to UX and configure basic nexus, use generated password and create new password if required
```
oc exec $(oc get pods -lapp=nexus --template='{{range .items}}{{.metadata.name}}{{end}}') -- cat /nexus-data/admin.password
```

Configure nexus
```
ansible-playbook -i inventory ocp-nexus-configure.yml
```

### Notes
- VersionPolicy: release, snapshot, mixed
- LayoutPolicy: strict, permissive
- blobStoreName: default
- strictContentTypeValidation: false = we need this, so that abstract pom types can be downloaded

```aidl
-- API
import org.sonatype.nexus.repository.maven.LayoutPolicy;
import org.sonatype.nexus.repository.maven.VersionPolicy;

public Repository createMavenProxy(String name, String remoteUrl, String blobStoreName, boolean strictContentTypeValidation, VersionPolicy versionPolicy, LayoutPolicy layoutPolicy);

-- Groovy

import org.sonatype.nexus.repository.maven.LayoutPolicy;
import org.sonatype.nexus.repository.maven.VersionPolicy;

repository.createMavenProxy('atlassian-snapshot', 'https://maven.atlassian.com/public-snapshot/', 'default', false, VersionPolicy.MIXED, LayoutPolicy.PERMISSIVE);
```
