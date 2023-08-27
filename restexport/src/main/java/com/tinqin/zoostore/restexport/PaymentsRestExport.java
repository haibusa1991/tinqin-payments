package com.tinqin.zoostore.restexport;


import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({
        "Content-Type: application/json"
})
public interface PaymentsRestExport {
    @RequestLine("GET /tags/{tagId}")
    String getTagById(@Param("tagId") String tagId);
}
