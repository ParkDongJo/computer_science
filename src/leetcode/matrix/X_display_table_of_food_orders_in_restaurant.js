//  https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/
/**
 * @param {string[][]} orders
 * @return {string[][]}
 */
var displayTable = function(orders) {
    // menus 의 맵핑
    // - 메뉴명이 key: idx 가 값
    // tables 의 맵핑
    // - 테이블 번호 key: 메뉴 배열이 값

    const menus = new Map();
    const tables = new Map();

    orders.sort((a, b) => a[2].localeCompare(b[2]))

    console.log(orders)

    let idx = 0;
    for (let i = 0; i < orders.length; i++) {
        if (!menus.has(orders[i][2])) {
            menus.set(orders[i][2], idx);
            idx++;
        }
    }

    
    for (let i = 0; i < orders.length; i++) {
        if (tables.has(orders[i][1])) {
            let newOrders = tables.get(orders[i][1]);
            newOrders[menus.get(orders[i][2])] = (parseInt(newOrders[menus.get(orders[i][2])]) + 1).toString();
            tables.set(orders[i][1], newOrders);
        } else {
            let initOrders = new Array(menus.size).fill("0");
            initOrders[menus.get(orders[i][2])] = "1";
            tables.set(orders[i][1], initOrders);
        }
    }

    console.log(menus);
    console.log(tables);
    return [
        ['Table', ...[...menus].map(([key, _]) => key)],
        ...[...tables]
        .sort((a, b) => a[0] - b[0])
        .map(([key, value]) => (
            [key, ...value]
        ))
    ]
};





var displayTable = function(orders) {
    var mapOrders = {};
    var tables = [];
    var dishes = [];
    for(var i=0;i<orders.length;i++){
		//if entry of table doesn't exist in mapOrders
        if(mapOrders[orders[i][1]] == undefined){
			//conver table number to integer
            var tableNo = Number(orders[i][1])
            mapOrders[tableNo] = {}
            mapOrders[tableNo][orders[i][2]] = 1;
			//if table number doesn't exist in table array, push it in the table array
            if(!tables.includes(tableNo)){tables.push(tableNo)}
			//if dish doesn't exist in dishes array, push it in the dishes array
            if(!dishes.includes(orders[i][2])){dishes.push(orders[i][2])}
        }else{
            //if entry of table exists in mapOrders
            //conver table number to integer
            var tableNo = Number(orders[i][1])
            var entry = mapOrders[tableNo];
            //check if entry of dish exists in for that table in mapOrders
            if(entry[orders[i][2]] == undefined){
                entry[orders[i][2]] = 1;
            }else{
                entry[orders[i][2]] = entry[orders[i][2]] + 1;
            }
            //if dish doesn't exist in dishes array, push it in the dishes array
            if(!dishes.includes(orders[i][2])){dishes.push(orders[i][2])}
        }
    }
    //sort tables and dishes
    tables.sort(function(a,b){return a-b});
    dishes.sort();
    //append word "Table" with all dish names om row[0] of result
    var res = [["Table"]];
    for(var i=0;i<dishes.length;i++){
        res[0].push(dishes[i]);
    }
    // read through map based on sorted table order
    for(var i=0;i<tables.length;i++){
        // append result in a temp array
        var tmp = [];
        //converting number to string using ""+
        tmp.push(""+tables[i]);
        for(var j=0;j<dishes.length;j++){
            if(mapOrders[tables[i]][dishes[j]]==undefined){
                //if dish doesn't exist against that table then append "0" to the result for that dish
                tmp.push(""+0);
            }else{
                //if dish exists against that table then append value in mapOrders for that pair of (table,dish) to the result
                tmp.push(""+mapOrders[tables[i]][dishes[j]]);
            }
        }
        //append the temp array in result
        res.push(tmp);
    }
    return res;
};