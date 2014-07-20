<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Jobs</title>
    <meta name="layout" content="main"/>
</head>
<body>

    <h1>Job list</h1>

    <p>There are ${total} jobs available</p>
    <div class="pagination">
        <g:paginate total="${total}" action="list" max="20"/>
    </div>

    <ul class="jobs">
        <g:each in="${jobs}" var="job">

            <li>
                <p>
                    <label>id </label>
                    <span>${job.jobId}</span>
                </p>
                <p>
                    <label>title </label>
                    <span>${job.title}</span>
                </p>
                <p>
                    <label>salary </label>
                    <span>${job.salary ?: 'n/a'}</span>
                </p>
                <p>
                    <label>region </label>
                    <span>${job.region}</span>
                </p>
            </li>
        </g:each>
    </ul>

</body>
</html>