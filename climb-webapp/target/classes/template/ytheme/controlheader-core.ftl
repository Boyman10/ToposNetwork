<#--
	Only show message if errors are available.
	This will be done if ActionSupport is used.
-->
<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if (parameters.errorposition!"top") == 'top'>
<#if hasFieldErrors>
<#list fieldErrors[parameters.name] as error>
<div class="form-group" errorFor="${parameters.id}">
    <label><#rt/>
        ${error?html}<#t/>
    </label><#lt/>
</div>
</#list>
</#if>
</#if>
<#if !parameters.labelposition?? && (parameters.form.labelposition)??>
<#assign labelpos = parameters.form.labelposition/>
<#elseif parameters.labelposition??>
<#assign labelpos = parameters.labelposition/>
</#if>
<#--
	if the label position is top,
	then give the label it's own row in the table
-->
<tr>
<#if (labelpos!"") == 'top'>
    <label><#rt/>
<#else>
    <label><#rt/>
</#if>
<#if parameters.label??>
    <label <#t/>
<#if parameters.id??>
        for="${parameters.id?html}" <#t/>
</#if>
<#if hasFieldErrors>
        class="errorLabel"<#t/>
<#else>
        class="label"<#t/>
</#if>
    ><#t/>
<#if (parameters.required!false) && ((parameters.requiredPosition!"right") != 'right')>
        <span class="required">*</span><#t/>
</#if>
${parameters.label?html}<#t/>
<#if (parameters.required!false) && ((parameters.requiredPosition!"right") == 'right')>
 <span class="required">*</span><#t/>
</#if>
${parameters.labelseparator!":"?html}<#t/>
<#include "/${parameters.templateDir}/${parameters.expandTheme}/tooltip.ftl" />
</label><#t/>
</#if>
    </label><#lt/>
<#-- add the extra row -->
<#if (labelpos!"") == 'top'>
</div>
<div>
</#if>
