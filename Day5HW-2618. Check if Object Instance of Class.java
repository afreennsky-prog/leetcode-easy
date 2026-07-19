/**
 * Returns true if `value` is an instance of `klass` or one of its superclasses.
 * An object is considered an instance if it has access to klass's methods
 * (i.e., klass.prototype appears in its prototype chain).
 *
 * @param {*} value
 * @param {*} klass
 * @returns {boolean}
 */
function checkIfInstanceOf(value, klass) {
  // klass must be a function with a prototype to be a "class"
  if (klass == null || typeof klass !== 'function' || klass.prototype == null) {
    return false;
  }

  // null and undefined cannot be instances
  if (value == null) return false;

  // For primitives (number, string, boolean, symbol, bigint) wrap them so
  // their wrapper object's prototype can be inspected.
  const obj = (typeof value === 'object' || typeof value === 'function') ? value : Object(value);

  let proto = Object.getPrototypeOf(obj);
  while (proto !== null) {
    if (proto === klass.prototype) return true;
    proto = Object.getPrototypeOf(proto);
  }
  return false;
}
