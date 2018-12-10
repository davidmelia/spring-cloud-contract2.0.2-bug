Run with Finchley.SR1 all works.

Run with Finchley.SR2 doesn't work with

2018-12-10 20:13:32.716 ERROR 73489 --- [o-auto-1-exec-2] o.a.c.c.C.[.[.[.[dispatcherServlet]      : Servlet.service() for servlet [dispatcherServlet] in context with path [/somepath] threw exception [Request processing failed; nested exception is org.springframework.web.client.ResourceAccessException: I/O error on PUT request for "http://localhost:6980/my-service/api/2/root/email": localhost:6980 failed to respond; nested exception is org.apache.http.NoHttpResponseException: localhost:6980 failed to respond] with root cause

org.apache.http.NoHttpResponseException: localhost:6980 failed to respond
	at org.apache.http.impl.conn.DefaultHttpResponseParser.parseHead(DefaultHttpResponseParser.java:141) ~[httpclient-4.5.6.jar:4.5.6]
	at org.apache.http.impl.conn.DefaultHttpResponseParser.parseHead(DefaultHttpResponseParser.java:56) ~[httpclient-4.5.6.jar:4.5.6]



You can run UpdateTest independently:
