Spring Security on Servicemix Tests
===================================

A project with my tests for studing if Spring Security can work on ServiceMix/Karaf

Please note building this project require the "parent" from this other project of mine: https://github.com/cristcost/sensormix/tree/master/parent

<b>The code may seems to be un-rational: the html page says about a 'GWT' example, but there is no GWT at all in this project! But please don't mind, it is due to copy and paste from other code.</b>

There are two users: "admin" and "user", both with password "123".

I've build the example progressively, adding one spring security features step by step. You can check the git tags to see the most relevant steps I've achieved. 

If you are interested in the example, feel free to open issues and I'll be glad to help or refine the examples for you to use it.


Running the demo out of ServiceMix
----------------------------------

I needed to compare the demo running in servicemix with another one outside of servicemix, so I used an embedded jetty and I run the web server with the class net.cristcost.launcher.JettyStart (on src/test/java)

However, spring-dm-web require a different contextClass instead of the spring web default. It is set with a context-param on web.xml:

```
<context-param>
	<param-name>contextClass</param-name>
	<param-value>org.springframework.osgi.web.context.support.OsgiBundleXmlWebApplicationContext
	</param-value>
</context-param>
```

to switch between the two, I often comment and uncomment the above inside the web-xml, and sometime I forgot to commit the code with it uncommented. If you get an error that says the schema "http://www.springframework.org/schema/mvc" can't be handled, check if the above snippet is commented!

