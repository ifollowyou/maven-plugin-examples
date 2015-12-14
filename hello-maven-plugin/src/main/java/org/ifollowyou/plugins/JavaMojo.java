package org.ifollowyou.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.project.MavenProject;

import java.io.File;

/**
 * Goal which create project directors.
 */
@Mojo(name = "java", requiresProject = true)
@Execute(phase = LifecyclePhase.NONE)
public class JavaMojo extends AbstractMojo {

    @Component
    private MavenProject project;

    public void execute() throws MojoExecutionException {

        String basePath = project.getBasedir().getAbsolutePath();

        // 检查输出目录
        String targetPath = basePath + "/target";
        createDir(new File(targetPath));

        // 检查资源目录
        String mainResourcePath = basePath + "/src/main/resources";
        createDir(new File(mainResourcePath));

        // 检查测试目录
        String testResourcePath = basePath + "/src/test/resources";
        createDir(new File(testResourcePath));
        String testJavaPath = basePath + "/src/test/java";
        createDir(new File(testJavaPath));
    }

    private void createDir(File dir) {
        if (!dir.exists()) {
            getLog().info("Creating dir [" + dir.getAbsolutePath() + "], result=" + dir.mkdirs());
        }
    }
}
