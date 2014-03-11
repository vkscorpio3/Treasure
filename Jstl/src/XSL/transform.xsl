<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : transform.xsl
    Created on : October 25, 2010, 11:40 AM
    Author     : root
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>transform.xsl</title>
            </head>
            <body>
            </body>
        </html>
    </xsl:template>



    <xsl:template match="student">
        <tr>
            <td>
                <xsl:value-of select="name/first"/>
            </td>
            <td>
                <xsl:value-of select="name/last"/>
            </td>
            <td>
                <xsl:value-of select="grade/points"/>
            </td>
            <td>
                <xsl:value-of select="grade/letter"/>
            </td>
        </tr>
    </xsl:template>





</xsl:stylesheet>
