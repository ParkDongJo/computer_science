/**
 * @param {string[]} words
 * @param {character} separator
 * @return {string[]}
 */
var splitWordsBySeparator = function(words, separator) {
  const results = [];
  for (let c of words) {
      c.split(separator).forEach((c) => {
          if (c !== "") {
              results.push(c);
          }
      });
  }
  return results;
};
