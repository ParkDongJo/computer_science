// https://leetcode.com/problems/maximum-units-on-a-truck
/**
 * @param {number[][]} boxTypes
 * @param {number} truckSize
 * @return {number}
 */
var maximumUnits = function(boxTypes, truckSize) {
  let empty = truckSize;
  let result = 0;
  boxTypes.sort(([aBox, aUnit], [bBox, bUnit]) => bUnit - aUnit)

  for (let [box, unit] of boxTypes) {
      if (empty >= box) {
          console.log(empty, box)
          empty = empty - box;
          result += box * unit;
      } else if (empty !== 0) {
          result += empty * unit;
          empty = 0
          break;
      } else {
          break;
      }
  }
  return result;
};