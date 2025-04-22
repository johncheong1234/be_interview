from sqlalchemy import create_engine, Column, Integer, String, Float
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

Base = declarative_base()

class Product(Base):
    """Product model representing a product table."""
    __tablename__ = 'products'
    
    id = Column(Integer, primary_key=True)
    name = Column(String(100), nullable=False)
    price = Column(Float, nullable=False)
    
    def __repr__(self):
        return f"<Product(id={self.id}, name='{self.name}', price={self.price})>"

# Example usage for querying products with price > 100
def get_expensive_products(database_url):
    """Query products with price > 100.0 from the database.
    
    Args:
        database_url: URL of the database (e.g., 'sqlite:///products.db')
        
    Returns:
        List of Product objects where price > 100.0
    """
    engine = create_engine(database_url)
    Base.metadata.create_all(engine)
    Session = sessionmaker(bind=engine)
    session = Session()
    
    expensive_products = session.query(Product).filter(Product.price > 100.0).all()
    session.close()
    return expensive_products

# Example setup (would normally be in a separate file)
if __name__ == '__main__':
    # This is just for demonstration - would normally connect to a real database
    engine = create_engine('sqlite:///:memory:')
    Base.metadata.create_all(engine)
    
    Session = sessionmaker(bind=engine)
    session = Session()
    
    # Add some test data
    session.add_all([
        Product(name="Laptop", price=999.99),
        Product(name="Phone", price=799.99),
        Product(name="Mouse", price=19.99),
        Product(name="Monitor", price=249.99)
    ])
    session.commit()
    
    # Query expensive products
    expensive = get_expensive_products('sqlite:///:memory:')
    print("Expensive products (price > 100):")
    for product in expensive:
        print(product)
    
    session.close()