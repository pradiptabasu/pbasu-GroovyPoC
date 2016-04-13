import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.Method

String url = 'http://oa8102.us.oracle.com:7201/'
HTTPBuilder http = new HTTPBuilder(url)

String uriPath = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService'

http.request( url, Method.GET, ContentType.TEXT ) { req ->
  uri.path = uriPath
  
  response.success = { resp, reader ->
    assert resp.statusLine.statusCode == 200
    println "Got response: ${resp.statusLine}"
    println "Content-Type: ${resp.headers.'Content-Type'}"
    println reader.text
  }
}

def num1=4
def num2=5

String uriPathGETmultiply = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService/multiply/'+num1+'/'+num2
http.request( url, Method.GET, ContentType.TEXT ) { req ->
  uri.path = uriPathGETmultiply
  
  response.success = { resp, reader ->
    assert resp.statusLine.statusCode == 200
    println "Got response: ${resp.statusLine}"
    println "Content-Type: ${resp.headers.'Content-Type'}"
    println reader.text
  }
}


String content = '{"num1": ' + num1 + ',"num2": ' + num2 + ' }'
String uriPathPOSTmultiply = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService/multiply'
http.request( url, Method.POST, ContentType.TEXT) { req ->
  uri.path = uriPathPOSTmultiply
  requestContentType = ContentType.JSON
  body =  content
  
  response.success = { resp, reader ->
    assert resp.statusLine.statusCode == 200
    println "Got response: ${resp.statusLine}"
    println "Content-Type: ${resp.headers.'Content-Type'}"
    println reader.text
  }
}
