const express = require('express')
const app = express()
const port = 3000

const redis = require('redis');
const client = redis.createClient({ url: "redis://localhost:6379" });

client.on('error', function(error) {
    console.error(error);
});

client.on("ready", () => {
    console.log('Connected to redis!');
});


app.post('', (req, res) => {
    client.set("key", "value", redis.print);
    client.get("key", redis.print);
    res.send("works");
});

app.get('', (req, res) => {
    console.log(req.query);
    client.set("key", "value", redis.print);
    client.get("key", redis.print);
    res.send('Hello World!')
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})
