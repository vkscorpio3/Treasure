<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet version="1.0"   xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
 xmlns:wxsl="http://www.e-mis.com/emisopen/MedicalRecord">
 <xsl:namespace-alias stylesheet-prefix="wxsl" result-prefix="xsl"/>
<xsl:template match="/">
	<externalScheduling>
		<xsl:apply-templates/> 
	</externalScheduling>
</xsl:template>
<xsl:template match="EMIS" >
			<visits>
			<xsl:for-each select="wxsl:BookedPatients/wxsl:BookedList/wxsl:Booked">
					<visit>
								<patientid><xsl:value-of select="wxsl:Patient/wxsl:DBID"/></patientid>
								<sex><xsl:value-of select="wxsl:Patient/wxsl:Sex"/></sex>
								<surname><xsl:value-of select="wxsl:Patient/wxsl:FamilyName"/></surname>
								<name><xsl:value-of select="wxsl:Patient/wxsl:FirstNames"/></name>
								<street><xsl:value-of select="wxsl:Patient/wxsl:Street"/></street>
								<town><xsl:value-of select="wxsl:Patient/wxsl:Town"/></town>
								<country><xsl:value-of select="wxsl:Patient/wxsl:Country"/></country>
								<mobile><xsl:value-of select="wxsl:Patient/wxsl:Mobile"/></mobile>
								<email><xsl:value-of select="wxsl:Patient/wxsl:Email"/></email>
								<appointmentid><xsl:value-of select="wxsl:Appointment/wxsl:ID/wxsl:DBID"/></appointmentid>
								<appointmentdate><xsl:value-of select="wxsl:Appointment/wxsl:Date"/></appointmentdate>								
								<appointmenttime><xsl:value-of select="wxsl:Appointment/wxsl:Time"/></appointmenttime>
								<doctorid><xsl:value-of select="wxsl:Appointment/wxsl:SessionHolder/wxsl:DBID"/></doctorid>
					</visit>
			</xsl:for-each>
			</visits>
			<doctors>
			<xsl:for-each select="wxsl:BookedPatients/wxsl:SessionHolderList/wxsl:SessionHolder">
				<doctor>
					<doctorid><xsl:value-of select="wxsl:DBID"/></doctorid>
					<name><xsl:value-of select="wxsl:FirstNames"/> <xsl:value-of select="wxsl:LastName"/></name>
					<email><xsl:value-of select="wxsl:Email"/></email>
					<phone><xsl:value-of select="wxsl:Telephone1"/></phone>
				</doctor>
			</xsl:for-each>
			</doctors>
</xsl:template>
</xsl:stylesheet>