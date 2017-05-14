<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <form method="GET" action="/java112/display-analyzer-reports">
        <select name="analyzerReports" id="analyzerReports">
            <option value="/tmp/summary_report.txt">Summary Report</option>
            <option value="/tmp/unique_tokens.txt">Unique Tokens</option>
            <option value="/tmp/token_count.txt">Token Count</option>
            <option value="/tmp/token_size.txt">Token Size</option>
            <option value="/tmp/big_words.txt">Big Words</option>
            <option value="/tmp/keyword_locations.txt">Keyword Locations</option>
        </select>
        <input type="submit" id="submitSearch" value="Submit"></input>
    </form>
</div>

<div>
    <pre>${analyzer}</pre>
</div>
