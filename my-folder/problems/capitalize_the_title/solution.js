/**
 * @param {string} title
 * @return {string}
 */
var capitalizeTitle = function(title) {
    let str = title.toLowerCase().split(' ');
    for(let i = 0; i < str.length; i++) {
        if(str[i].length > 2) {
            str[i] = str[i].charAt(0).toUpperCase() + str[i].slice(1)
        }
    }
    return str.join(' ')
};