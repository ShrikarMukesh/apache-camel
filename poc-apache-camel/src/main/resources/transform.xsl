<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Define variables -->
    <xsl:variable name="discountPercent" select="0.1" />

    <!-- Main template -->
    <xsl:template match="customer_info">
        <output>
            <!-- If condition to check specific customer data -->
            <xsl:if test="age &gt; 30">
                <message>This customer is over 30 years old.</message>
            </xsl:if>

            <!-- Value-of to output the value of customer's name -->
            <customerName>
                <xsl:value-of select="name"/>
            </customerName>

            <!-- Choose condition -->
            <xsl:choose>
                <xsl:when test="gender = 'Male'">
                    <message>This customer is male.</message>
                </xsl:when>
                <xsl:otherwise>
                    <message>This customer is female.</message>
                </xsl:otherwise>
            </xsl:choose>

            <!-- Example of xsl:with-param -->
            <xsl:call-template name="processAddress">
                <xsl:with-param name="street" select="address/street"/>
                <xsl:with-param name="city" select="address/city"/>
                <!-- Add more parameters as needed -->
            </xsl:call-template>

            <!-- Example of entry key -->
            <xsl:apply-templates select="accounts"/>
        </output>
    </xsl:template>

    <!-- Template for processing address -->
    <xsl:template name="processAddress">
        <xsl:param name="street"/>
        <xsl:param name="city"/>
        <address>
            <street><xsl:value-of select="$street"/></street>
            <city><xsl:value-of select="$city"/></city>
        </address>
    </xsl:template>

    <!-- Template for accounts -->
    <xsl:template match="accounts">
        <xsl:for-each select="account">
            <entry>
                <key><xsl:value-of select="type"/></key>
                <value><xsl:value-of select="balance"/></value>
            </entry>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
