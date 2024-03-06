<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>

    <!-- Match the root element -->
    <xsl:template match="/">
        {
        "Customer": {
        "CustomerID": "<xsl:value-of select="Customer/CustomerID"/>",
        "FirstName": "<xsl:value-of select="Customer/FirstName"/>",
        "LastName": "<xsl:value-of select="Customer/LastName"/>",
        "Address": {
        "Street": "<xsl:value-of select="Customer/Address/Street"/>",
        "City": "<xsl:value-of select="Customer/Address/City"/>",
        "State": "<xsl:value-of select="Customer/Address/State"/>",
        "PostalCode": "<xsl:value-of select="Customer/Address/PostalCode"/>",
        "Country": "<xsl:value-of select="Customer/Address/Country"/>"
        },
        "ContactInfo": {
        "Email": "<xsl:value-of select="Customer/ContactInfo/Email"/>",
        "Phone": {
        "Mobile": "<xsl:value-of select="Customer/ContactInfo/Phone/Mobile"/>",
        "Home": "<xsl:value-of select="Customer/ContactInfo/Phone/Home"/>"
        }
        },
        "Accounts": {
        "Account": {
        "AccountID": "<xsl:value-of select="Customer/Accounts/Account/AccountID"/>",
        "AccountType": "<xsl:value-of select="Customer/Accounts/Account/AccountType"/>",
        "Balance": "<xsl:value-of select="Customer/Accounts/Account/Balance"/>",
        "Currency": "<xsl:value-of select="Customer/Accounts/Account/Currency"/>",
        "Branch": "<xsl:value-of select="Customer/Accounts/Account/Branch"/>",
        "LinkedCards": {
        "Card": [
        <xsl:apply-templates select="Customer/Accounts/Account/LinkedCards/Card"/>
        ]
        }
        }
        }
        }
        }
    </xsl:template>

    <!-- Match Card element -->
    <xsl:template match="Card">
        {
        "CardNumber": "<xsl:value-of select="CardNumber"/>",
        "CardType": "<xsl:value-of select="CardType"/>",
        "ExpirationDate": "<xsl:value-of select="ExpirationDate"/>",
        "SecurityCode": "<xsl:value-of select="SecurityCode"/>"
        }
        <xsl:if test="position() != last()">,</xsl:if>
    </xsl:template>
</xsl:stylesheet>
