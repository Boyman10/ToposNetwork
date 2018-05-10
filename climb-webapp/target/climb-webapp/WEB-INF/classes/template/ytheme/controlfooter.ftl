${parameters.after!}<#t/>
    </td><#lt/>
</tr>
<#if (parameters.errorposition!"top") == 'bottom'>
<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
<#list fieldErrors[parameters.name] as error>
<tr errorFor="${parameters.id}">
    <td class="tdErrorMessage" colspan="2"><#rt/>
        <span class="errorMessage">${error?html}</span><#t/>
    </td><#lt/>
</tr>
</#list>
</#if>
</#if>
<footer>
HELLO FOOTER
</footer>