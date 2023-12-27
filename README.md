# 项目模板标准工程

## 使用说明
- [下载代码](https://github.com/kylin-fire/project-template.git)
- 进入代码路径

```shell
    cd project-template
```

- 构建工程，执行build.sh（带上appname作为参数，例如pay）

```shell
    ./build.sh ${appName} ${group} ${package}
```

- 构建后，将在project-template下生成${appName}目录
- 拷贝工程目录到workspaces目录，用作代码目录