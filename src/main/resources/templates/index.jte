@import net.dishevelled.App;

@param String name
@param java.util.Date now
@param java.util.List<App.FileEntry> files

<!doctype html>
<html>
    <head>
        <title></title>
        <meta charset="utf-8" />
    </head>
    <body>
        <p>Hello, ${name}.  The time is <pre>${now.toString()}</pre>.</p>

        @if(now.getHours() < 12)
          <p>It's before lunch</p>
        @else
          <p>It's after lunch</p>
        @endif

       <table>
           <tr><th>Name</th><th>Size</th><th>Type</th></tr>
           @for(App.FileEntry entry : files)
             <tr><td>${entry.filename()}</td><td>${entry.size()}</td><td>${entry.mimeType()}</td></tr>
           @endfor
       </table>

       @template.subtemplate(files)
    </body>
</html>
