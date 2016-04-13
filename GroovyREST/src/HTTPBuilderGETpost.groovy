import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
String url = 'http://oa8102.us.oracle.com:7201/'
HTTPBuilder http = new HTTPBuilder(url)

String uriPath = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService'
http.get(path:uriPath) { resp, reader ->;
     println reader.text
     println resp.statusLine
}

def num1=4
def num2=5

String uriPathGETmultiply = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService/multiply/'+num1+'/'+num2
http.get( path : uriPathGETmultiply, contentType : ContentType.TEXT) { resp, reader ->;
     println reader.text
     println resp.statusLine
}

String content = '{"num1": ' + num1 + ',"num2": ' + num2 + ' }'
String uriPathPOSTmultiply = 'APICSDemoBackendServicesREST/rest/PublicCalculatorService/multiply'
http.post(path:uriPathPOSTmultiply, body:content, requestContentType:ContentType.JSON,contentType : ContentType.TEXT) { resp, reader ->;
     println  reader.text
     println resp.statusLine
     println resp.statusLine.statusCode
}