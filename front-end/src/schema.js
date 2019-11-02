export const typeDefs = `
type Customer {
  id: String!
  name: String!
}

type Query {
  customers: [Customer]
}
`