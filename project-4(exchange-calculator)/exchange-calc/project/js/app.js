let input = document.getElementById("input");
let from = document.getElementById("from");
let to = document.getElementById("to");
let result = document.getElementById("result");
let historyList = document.getElementById("historyList");
let td4 = document.getElementById("td4");
let i = 1;
function createOption(x,y,z) {
    let o = document.createElement("option");
    let t = document.createTextNode(y);
    o.setAttribute("value",toNum(z));
    o.appendChild(t);
    x.appendChild(o);
}
function toNum(x) {
    return Number(x.replace(",",""));
}
for (let x in data.rates){
    createOption(from,x,data.rates[x]);
    // console.log(x,data.rates[x]);
}
for (let x in data.rates){
    createOption(to,x,data.rates[x]);
    // console.log(x,data.rates[x]);
}
function createTr(x){
        let rowSpacer = document.getElementById("rowSpacer");
        if (rowSpacer){
            rowSpacer.remove();
        }
        let tr = document.createElement("tr");
        // tr.setAttribute("id","tr"+i+"" );

        x.map(function (el,index) {
            let td = document.createElement("td");
            let text = document.createTextNode(el);
            td.appendChild(text);
            tr.appendChild(td);
            // td.setAttribute("id","td"+i+"")
        });

        historyList.appendChild(tr);
        i++;
}
function store(){
    localStorage.setItem("record",historyList.innerHTML);
}
document.getElementById("calc").addEventListener("submit",function (e) {
    e.preventDefault();

    //get
    let historyContainer = document.getElementById("historyContainer");
    let x = input.value;
    let y = from.value;
    let z = to.value;
    // console.log(x,y,z);

    //process
    let fromText = x+" "+from.options[from.selectedIndex].innerHTML;
    let toText =to.options[to.selectedIndex].innerHTML;
    console.log(toText);
    let first = x * y;
    // console.log(first);
    let second = first/z;
    let resultTwo = second.toFixed(2) + " " + toText ;

    let date = new Date().toLocaleString();
    let arr = [date,fromText,toText,resultTwo];
    // console.log(second.toFixed(2));
    createTr(arr);
    store();

    //setData
    result.innerHTML = resultTwo;
    input.value = "" ;
    input.focus();
    from.value = "";
    to.value = 1;
});

(function () {
    if (localStorage.getItem("record")){
        historyList.innerHTML = localStorage.getItem("record");
    }else{
        historyList.innerHTML = `<tr id="rowSpacer"><td colspan="5">There is no record</td></tr>` ;
    }
})();

function deleteHistory() {
    localStorage.clear();
    historyList.innerHTML = "";
    historyList.innerHTML = `<tr id="rowSpacer"><td colspan="5">There is no record</td></tr>` ;
}

function changeMode() {
    document.body.classList.toggle("night-mode");
    document.getElementById("mode-icon").classList.toggle("fa-sun");
}


