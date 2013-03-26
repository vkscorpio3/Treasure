<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>transform.xsl</title>
                <table border="1">                
                <xsl:apply-templates />
                </table>                               
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
