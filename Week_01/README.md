学习笔记

- 1 （可选）、自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和
for，然后自己分析一下对应的字节码，有问题群里讨论。

todo

- 2 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件

code 文件夹下 HelloClassLoader.java 文件

- 3 画一张图，展示 Xmx、Xms、Xmn、Metaspache、DirectMemory、Xss
这些内存参数的关系
![relation](./img/relation.png)


- 4（可选）、检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap
查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。
注意：
    - 1、对于线上有流量的系统，慎重使用jmap命令。
    - 2、如果没有线上系统，可以自己 run 一个 web/java 项目。或者直接查看idea进程。