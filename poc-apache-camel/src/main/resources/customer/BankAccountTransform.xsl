<!-- BankAccountTransform.xsl -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Identity transform to copy all elements and attributes -->
    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>

    <!-- Transforming accountNumber element -->
    <xsl:template match="accountNumber">
        <AccountNumber>
            <xsl:apply-templates/>
        </AccountNumber>
    </xsl:template>

    <!-- Transforming balance element -->
    <xsl:template match="balance">
        <Balance>
            <xsl:apply-templates/>
        </Balance>
    </xsl:template>

    <!-- Transforming cards element -->
    <xsl:template match="cards">
        <Cards>
            <xsl:apply-templates/>
        </Cards>
    </xsl:template>

    <!-- Transforming card element -->
    <xsl:template match="card">
        <Card>
            <xsl:apply-templates/>
        </Card>
    </xsl:template>

    <!-- Transforming linkedParties element -->
    <xsl:template match="linkedParties">
        <LinkedParties>
            <xsl:apply-templates/>
        </LinkedParties>
    </xsl:template>

    <!-- Transforming linkedParty element -->
    <xsl:template match="linkedParty">
        <LinkedParty>
            <xsl:apply-templates/>
        </LinkedParty>
    </xsl:template>

</xsl:stylesheet>
