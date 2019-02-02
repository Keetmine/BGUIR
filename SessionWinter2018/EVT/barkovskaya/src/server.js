const path = require('path');
const fs = require('fs');
const express = require('express');
const multer = require('multer');
const bodyParser = require('body-parser')
const app = express();
const router = express.Router();
const DIR = './uploads';

let storage = multer.diskStorage({
    destination: (req, file, cb) => {
        cb(null, DIR);
    },
    filename: (req, file, cb) => {
        console.log(file)
        cb(null, file.originalname);
    }
});
let upload = multer({storage: storage});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.use(function (req, res, next) {
    res.setHeader('Access-Control-Allow-Origin', 'http://localhost:4200');
    res.setHeader('Access-Control-Allow-Methods', 'POST');
    res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
    res.setHeader('Access-Control-Allow-Credentials', true);
    next();
});

app.get('/api', function (req, res) {
    res.end('file catcher example');
});


app.post('/api/upload',upload.single('photo'), function (req, res) {
    if (!req.file) {
        console.log("No file received");
        return res.send({
            success: false
        });

    } else {
        console.log('file received');
        return res.send({
            success: true
        })
    }
});

app.use('/uploads', express.static('uploads'));


app.get('/api/uploads', function (req, res) {
    let item = []
    fs.readdirSync(DIR).forEach(file => {
        console.log(file);
        item.push({src: 'http://localhost:3000/uploads/' + file,name:file.split('.').slice(0, -1).join('.'), type: file.split('.')[file.split('.').length - 1]})
    })
    res.send(JSON.stringify(item))
});


const PORT = process.env.PORT || 3000;

app.listen(PORT, function () {
    console.log('Node.js server is running on port ' + PORT);
});


